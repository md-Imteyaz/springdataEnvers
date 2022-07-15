package com.SpringdataEnvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringdataEnvers.Repository.BookRepo;
import com.SpringdataEnvers.model.Book;

@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)

public class SpringdataEnversApplication {

	@Autowired
	private BookRepo bookrepo;

	@PostMapping("/savebook")
	public Book savebook(@RequestBody Book book) {
		return bookrepo.save(book);

	}

	@PutMapping("/updatebook/{id}/{pages}")
	public String Updatebook(@PathVariable long id, @PathVariable int pages) {
		Book book = bookrepo.findById(id).get();
		book.setPages(pages);
		return "Book updated";

	}

	@DeleteMapping("/delete/{id}")
	public String deletebook(@PathVariable long id) {
		bookrepo.deleteById(id);
		return "book is deleted successfully";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdataEnversApplication.class, args);
	}

}
