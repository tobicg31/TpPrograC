package model.elementosUniverso;

public interface InteraccionNave {
    boolean choca(InteraccionNave nave);
    boolean chocaExploradora();
    boolean chocaCarguera();
    boolean chocaCombate();
}
