package ir.javacup.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<U, T extends IEntity<U>>
        implements IRepository<U, T> {
    protected Map<U, T> data = new HashMap<>();
    protected IdGenerator<U> idGenerator;

    public AbstractRepository(){

    }

    public AbstractRepository(IdGenerator<U> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public T load(U id) {
        return data.get(id);
    }

    @Override
    public List<T> loadAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void save(T entity) {
        if(entity == null)
            throw new IllegalArgumentException("You want me to save null but I can't!");
        entity.setId(idGenerator.generate());
        data.put(entity.getId(), entity);
    }

    @Override
    public void update(T entity) {
        if(entity.getId() == null)
            throw new IllegalArgumentException("input argument has no id!");
        if(!data.containsKey(entity.getId()))
            throw new RuntimeException("There is no data saved with this Id!");
        data.put(entity.getId(), entity);
    }

    @Override
    public void delete(U id) {
        if(!data.containsKey(id))
            throw new RuntimeException("There is no data saved with this Id!");
        data.remove(id);
    }

    @Override
    public void deleteAll() {
        data.clear();
    }
}
