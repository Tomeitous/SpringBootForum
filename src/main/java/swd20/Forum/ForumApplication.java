package swd20.Forum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import swd20.Forum.domain.Comment;
import swd20.Forum.domain.CommentRepository;
import swd20.Forum.domain.ThreadRepository;
import swd20.Forum.domain.Thread;
import swd20.Forum.domain.Topic;
import swd20.Forum.domain.TopicRepository;
import swd20.Forum.domain.User;
import swd20.Forum.domain.UserRepository;



@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(CommentRepository repository, TopicRepository trepository, UserRepository urepository, ThreadRepository threpository)
	
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("tome", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "USER");
			User user4 = new User("alisa", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "USER");		
			
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			
			Topic v1 = new Topic("Dogs");
			Topic v2 = new Topic("TV");
			Topic v3 = new Topic("School");
			
			trepository.save(v1);
			trepository.save(v2);
			trepository.save(v3);
			
			Thread t1 = new Thread("Dogs thread", trepository.findByName("Dogs").get(0));
			Thread t2 = new Thread("Why dogs are the best:", trepository.findByName("Dogs").get(0));
			Thread t3 = new Thread("Pictures of your dogs", trepository.findByName("Dogs").get(0));
			Thread t4 = new Thread("TV thread", trepository.findByName("TV").get(0));
			Thread t5 = new Thread("Favorite TV series", trepository.findByName("TV").get(0));
			Thread t6 = new Thread("Breaking Bad thread", trepository.findByName("TV").get(0));
			Thread t7 = new Thread("Java", trepository.findByName("School").get(0));
			Thread t8 = new Thread("JS", trepository.findByName("School").get(0));
			Thread t9 = new Thread("Python", trepository.findByName("School").get(0));
			Thread t10 = new Thread("HTML", trepository.findByName("School").get(0));
			
			
			threpository.save(t1);
			threpository.save(t2);
			threpository.save(t3);
			threpository.save(t4);
			threpository.save(t5);
			threpository.save(t6);
			threpository.save(t7);
			threpository.save(t8);
			threpository.save(t9);
			threpository.save(t10);
			
			
			
			trepository.findAll().forEach((topic) -> {
				logger.info("{}", topic);
			});
			
			Comment va1 = new Comment("dog good!", urepository.findByUsername("tome"), threpository.findByName("Dogs thread").get(0));
			Comment va2 = new Comment("dog cute!", urepository.findByUsername("alisa"), threpository.findByName("Dogs thread").get(0));
			Comment va3 = new Comment("love dogs!", urepository.findByUsername("user"), threpository.findByName("Dogs thread").get(0));
			Comment va4 = new Comment("me too!", urepository.findByUsername("tome"), threpository.findByName("Dogs thread").get(0));
			Comment va5 = new Comment("yeah!", urepository.findByUsername("alisa"), threpository.findByName("Dogs thread").get(0));
			Comment va10 = new Comment("they're so cute", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va6 = new Comment("petting them is nice", urepository.findByUsername("tome"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va7 = new Comment("dog best!", urepository.findByUsername("user"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va8 = new Comment("dog!", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va9 = new Comment("yeah!", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va11 = new Comment("I love watching breaking bad!", urepository.findByUsername("tome"), threpository.findByName("TV thread").get(0));
			Comment va12 = new Comment("Better Call Saul is also good!", urepository.findByUsername("admin"), threpository.findByName("TV thread").get(0));
			Comment va13 = new Comment("I don't watch TV", urepository.findByUsername("tome"), threpository.findByName("TV thread").get(0));
			Comment va14 = new Comment("I wish I had a dog", urepository.findByUsername("tome"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va15 = new Comment("I have 3 dogs", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va16 = new Comment("dogs are so awesome!", urepository.findByUsername("user"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va17 = new Comment("they're so cute", urepository.findByUsername("tome"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va18 = new Comment("they're so cute", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va19 = new Comment("they're so cute", urepository.findByUsername("tome"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va20 = new Comment("they're so cute", urepository.findByUsername("user"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va21 = new Comment("they're so cute", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va22 = new Comment("they're so cute", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va23 = new Comment("they're so cute", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			Comment va24 = new Comment("they're so cute", urepository.findByUsername("alisa"), threpository.findByName("Why dogs are the best:").get(0));
			

			repository.save(va1);
			repository.save(va2);
			repository.save(va3);
			repository.save(va4);
			repository.save(va5);
			repository.save(va6);
			repository.save(va7);
			repository.save(va8);
			repository.save(va9);
			repository.save(va10);
			
			repository.findAll().forEach((comment) -> {
				logger.info("{}", comment);
			});
			

		};
		}

}
