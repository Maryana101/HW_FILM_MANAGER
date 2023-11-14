import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Film film1 = new Film(1, "Бладшот");
    Film film2 = new Film(2, "Вперед");
    Film film3 = new Film(3, "Отель Белград");
    Film film4 = new Film(4, "Джентельмены");
    Film film5 = new Film(5, "Человек-невидимка");
    Film film6 = new Film(6, "Тролли. Мировой тур");
    Film film7 = new Film(7, "Номер один");

    Manager managerWithDefaultLimit = new Manager();
    Manager managerWithUndefaultLimit = new Manager(3);

    @Test
    public void shouldAddNewFilm() {
        managerWithDefaultLimit.add(film1);
        managerWithDefaultLimit.add(film3);
        managerWithDefaultLimit.add(film4);
        managerWithDefaultLimit.add(film5);
        managerWithDefaultLimit.add(film7);
        Film[] actual = managerWithDefaultLimit.findAll();
        Film[] expected = {film1, film3, film4, film5, film7};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnLastFilmsWithDefaultLimit() {
        managerWithDefaultLimit.add(film1);
        managerWithDefaultLimit.add(film2);
        managerWithDefaultLimit.add(film3);
        managerWithDefaultLimit.add(film4);
        managerWithDefaultLimit.add(film5);
        managerWithDefaultLimit.add(film6);
        managerWithDefaultLimit.add(film7);
        Film[] actual = managerWithDefaultLimit.findLast();
        Film[] expected = {film7, film6, film5, film4, film3};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnLastFilmsWithDefaultLimitLess() {
        managerWithDefaultLimit.add(film1);
        managerWithDefaultLimit.add(film2);
        managerWithDefaultLimit.add(film3);
        Film[] actual = managerWithDefaultLimit.findLast();
        Film[] expected = {film3, film2, film1};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnLastFilmsWithUndefaultLimit() {
        managerWithUndefaultLimit.add(film1);
        managerWithUndefaultLimit.add(film2);
        managerWithUndefaultLimit.add(film3);
        managerWithUndefaultLimit.add(film4);
        Film[] actual = managerWithUndefaultLimit.findLast();
        Film[] expected = {film4, film3, film2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnLastFilmsWithUndefaultLimitLess() {
        Manager managerWithUndefaultLimit = new Manager(10);
        managerWithUndefaultLimit.add(film1);
        managerWithUndefaultLimit.add(film2);
        managerWithUndefaultLimit.add(film3);
        managerWithUndefaultLimit.add(film4);
        managerWithUndefaultLimit.add(film5);
        managerWithUndefaultLimit.add(film6);
        managerWithUndefaultLimit.add(film7);
        Film[] actual = managerWithUndefaultLimit.findLast();
        Film[] expected = {film7, film6, film5, film4, film3, film2, film1};
        assertArrayEquals(expected, actual);

    }


}