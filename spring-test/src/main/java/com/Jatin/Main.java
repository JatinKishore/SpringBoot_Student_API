package com.Jatin;

import com.Jatin.Student.Student;
import com.Jatin.Student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication//Comprises 3 necessary annotations into one that are @EnableAutoConfiguration,@ComponentScan , @Configuration
//@EnableAutoConfiguration -> this helps to run the jar dependency files. Eg: We dont have tomcat embedded server locally in our system..But we have jar file installed for it..SpringBoot configures all the dependencies based on the jar files available..
//@ComponentScan -> This helps to locate packages.. We can also manually give package location . Eg: @ComponentScan(basepackage = "com.Jatin")

public class Main {
    public static void main(String[] args) {

       ConfigurableApplicationContext configurableApplicationContext =  SpringApplication.run(Main.class,args);
       String[] beanDefinitionNames = configurableApplicationContext.getBeanDefinitionNames();

//       for(String beanDefinitions: beanDefinitionNames ){
//           System.out.println(beanDefinitions);
//       }
    }
    @Bean
    CommandLineRunner cmdRunner(StudentRepository studentRepository){
        return args -> {
            Student ayyas = new Student("Ayyas",1,"ayas@gamil.com",11);
            Student aravind = new Student("Aravind",2,"arav@gamil.com",12);

            List<Student> students = List.of(ayyas, aravind);
            studentRepository.saveAll(students);
        };
    }

//      @GetMapping("/sayhi")
//    public GiveResponse SayHi(){
//        return new GiveResponse("Jatin", List.of("SecA", "SecB","SecC"), new People("Jatin"));
//
//    }
//    record People(String name){};
//    record GiveResponse(String message, List<String> sections,People people){};
//

//    class GiveResponse{ ->What is within record class
//        private final String msg;
//
//
//        GiveResponse(String msg) {
//            this.msg = msg;
//        }
//
//        public String getResponse() {
//            return msg;
//        }
//
//        @Override
//        public String toString(){
//            return "{" +
//                    "msg=" + msg + " "+
//                    "}";
//        }
//
//        @Override
//        public boolean equals(Object o){
//            if(this==o) return true;
//            if(o==null || getClass() == o.getClass()) return false;
//            GiveResponse that = (GiveResponse) o;
//            return Objects.equals(msg,that.msg);
//        }
//
//        @Override
//        public int hashCode(){return Objects.hash(msg);}
//
//    }


}
