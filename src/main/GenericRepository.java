package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class GenericRepository<T extends Entity & Comparable<T>> {
    protected final List<T> entities = new ArrayList<>();
    private final Logger logger = Logger.getLogger(getClass().getName());

    public void add(T entity) {
        entities.add(entity);
        logger.log(Level.INFO, "Додано нову сутність: {0}", entity);
    }

    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    public void sortByIdentity(String order) {
        String finalOrder = (order != null) ? order.toUpperCase() : "ASC";
        Comparator<T> idComparator = Comparator.comparing(Entity::getId);

        if ("DESC".equals(finalOrder)) {
            idComparator = idComparator.reversed();
        }

        entities.sort(idComparator);
        logger.log(Level.INFO, "Виконано сортування за ID в порядку: {0}", finalOrder);
    }

    protected void sort(Comparator<T> comparator, String order, String criterion) {
        String finalOrder = (order != null) ? order.toUpperCase() : "ASC";
        Comparator<T> currentComparator = comparator;

        if ("DESC".equals(finalOrder)) {
            currentComparator = currentComparator.reversed();
        }

        entities.sort(currentComparator);
        logger.log(Level.INFO, "Виконано сортування за критерієм '{0}' в порядку: {1}",
                new Object[]{criterion, finalOrder});
    }
}