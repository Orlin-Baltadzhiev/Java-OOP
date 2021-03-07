package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {
        DrawingRepository repository = new ShapeRepository();

        Renderer renderer =new RendererImpl() ;

        DrawingManager manager = new DrawingManagerImpl(repository,renderer);
        manager.draw(new Rectangle(12,13));
    }
}
