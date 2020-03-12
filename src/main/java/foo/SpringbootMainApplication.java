package foo;

import foo.api.FS;
import foo.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Set;

@SpringBootApplication
public class SpringbootMainApplication implements CommandLineRunner {

    @Autowired
    private FS fs;

    @Autowired
    private ApplicationContext context;

//    @Autowired(required = false)
//    private Set<Task> tasks;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fs.copy();
        Task task = (Task) context.getBean("foo.ModuleATask");
        task.run();
//        System.out.println(tasks);
    }
}
