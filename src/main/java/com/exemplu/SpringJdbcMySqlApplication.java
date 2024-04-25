package com.exemplu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringJdbcMySqlApplication implements CommandLineRunner{
	@Autowired
	PersoanaJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcMySqlApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nToate persoanele:");
		dao.findAll().forEach(System.out::println);
		System.out.println("\nPersoana cu id-ul 1:"+dao.findById(1));
		System.out.println("\nSterge persoana cu id-ul 1, numarul de randuri sterse: "
				+dao.deleteById(1));
		System.out.println("\nAdauga persoana cu id-ul 1, numarul de randuri adaugate: "
				+ dao.insert(new Persoana(1,"Ana",20)));
		System.out.println("\nActualizarea persoana cu id-ul 1, numarul de randuri actualizate:"
				+ dao.update(new Persoana(1,"Joline",30)));
		System.out.println("\nToate persoanele dupa adaugare, actualizare, stergere:");
		dao.findAll().forEach(System.out::println);
	}
}
