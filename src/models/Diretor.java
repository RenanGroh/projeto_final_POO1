package models;
public class Diretor extends Pessoa {

    private String area;

    public Diretor(String nome, int idade, String identidade, String area) {
        super(nome, idade, identidade);
        validaArea(area);

        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        validaArea(area);
        this.area = area;
    }

    // VALIDAÇÃO
    private void validaArea(String area) {
        if (area == null || area.isEmpty()) {
            throw new IllegalArgumentException("Área inválida!");
        }
    }
}