package ir.javacup.db;


class User implements IEntity<String>{
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}

class Person implements IEntity<Long>{
    private Long id;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
public class Main {
    public static void main(String[] args) {
        IEntity<String> user = new User();
        IEntity<Long> person = new Person();

        IdGenerator<String> stringIdGenerator = new StringIdGenerator();
        IdGenerator<Long> numericIdGenerator = new NumericIdGenerator();

        IRepository<String, User> userRepository = new UserRepository(stringIdGenerator);
        AbstractRepository<Long, Person> personRepository = new PersonRepository(numericIdGenerator);
    }
}

class NumericIdGenerator implements IdGenerator<Long>{

    @Override
    public Long generate() {
        return 1234L;
    }
}

class StringIdGenerator implements IdGenerator<String>{

    @Override
    public String generate() {
        return "sad";
    }
}

class UserRepository extends AbstractRepository<String, User>{

    public UserRepository(IdGenerator<String> stringIdGenerator) {
        this.idGenerator = stringIdGenerator;
    }
}

class PersonRepository extends AbstractRepository<Long, Person>{

    public PersonRepository(IdGenerator<Long> numericIdGenerator) {
        this.idGenerator = numericIdGenerator;
    }
}
