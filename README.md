**Building Dynamic Spring Boot Validators**  
https://medium.com/@bubu.tripathy/building-dynamic-spring-boot-validators-a066e6996df6  


**Test Student with**  

```bash
curl --location 'localhost:8080/students' \
--form 'name="Alex"' \
--form 'age="17"'
```

```bash
curl --location 'localhost:8080/students' \
--form 'name="Alex"' \
--form 'age="18"'
```

**Test Teacher with**  

```bash
curl --location 'localhost:8080/teachers' \
--form 'name="Bob"' \
--form 'experience="2"'
```

```bash
curl --location 'localhost:8080/teachers' \
--form 'name="Bob"' \
--form 'experience="3"'
```