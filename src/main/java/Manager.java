public class Manager {

    private Film[] films = new Film[0];
    private int limit = 5;

    public Manager() {
    }

    public Manager(int limit) {
        this.limit = limit;
    }

    public void add(Film newFilm) {
        Film[] tmp = new Film[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = newFilm;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];

        }
        return result;
    }


}
