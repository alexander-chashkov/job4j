package pseudo;
/**
 *  @version 0.0.0.1
 *  @since 2018.12.08
 *  @author Chashkov Alexander
 *  Square
 */
public class Square implements Shape {
    /**
     * @return нарисованный квадрат
     */
    @Override
    public String draw() {
        String sep = System.lineSeparator();
        StringBuilder pic = new StringBuilder();
        pic.append("█████████");
        pic.append(sep);
        pic.append("█           █");
        pic.append(sep);
        pic.append("█           █");
        pic.append(sep);
        pic.append("█           █");
        pic.append(sep);
        pic.append("█           █");
        pic.append(sep);
        pic.append("█████████");
        pic.append(sep);
        return pic.toString();
    }
}
