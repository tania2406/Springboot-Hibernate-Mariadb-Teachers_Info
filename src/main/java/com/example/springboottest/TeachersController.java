package com.example.springboottest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachersController {

	@Autowired
	TeachersRepository erepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is test for teacher";
	}
	@RequestMapping("/save")
	public String save (@RequestBody Teachers teacher)
	{
		erepo.save(teacher);
		return "data have been saved";
		
	}
	@RequestMapping("/all")
	public List<Teachers>alldata()
	{
		return erepo.findAll();
	}
	@RequestMapping("/{id}")
	public Optional<Teachers> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@RequestMapping("name/{name}")
	public List<Teachers>byname(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	@RequestMapping("/city/{city}")
	public List<Teachers>bycity(@PathVariable String city)
	{
		return erepo.findByCity(city);
	}
	@RequestMapping("/both/{name}/{city}")
     public List<Teachers>both(@PathVariable String name , @PathVariable String city)
     { return erepo.findByNameAndCity(name , city);
     }
	@RequestMapping("/duo/{name}/{age}")
	public List<Teachers>duo (@PathVariable String name , @PathVariable int age)
	{
		return erepo.findByNameAndAge(name,age);
				}
	@RequestMapping("/or/name/age")
	public List<Teachers> or(@PathVariable String name , @PathVariable int age)
	{
		return erepo.findByNameOrAge(name,age);
	}
	@RequestMapping("/del/{id}")
	public String del (@PathVariable int id)
	{ 
		erepo.findById(id).get();
		erepo.deleteById(id);
		return "data deleted";
	}
	@RequestMapping("/upd/{id}")
	public Teachers update (@RequestBody Teachers teacher , @PathVariable int id)
	{ 
		Teachers b=erepo.findById(id).get();
		b.setName(teacher.getName());
		b.setAge(teacher.getAge());
		b.setCity(teacher.getCity());
		return erepo.save(b);	
	}
	@RequestMapping("/or/{name}/{city}")
	public List<Teachers> find (@PathVariable String name, @PathVariable String city)
	{
	
		return erepo.findByNameOrCity(name,city);
	}	 
}
