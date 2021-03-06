
package daos;

import java.util.List;

/**
 *
 * @author formation
 * @param <T>
 */
public interface IDAO<T> {

    // --- CRUD+
    public abstract int insert(T objet);
    public abstract List<T> selectAll();
    public abstract T selectOne(int id);
    public abstract int delete(T objet);
    public abstract int update(T objet);
    
} /// Interface