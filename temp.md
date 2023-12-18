// 1. 工厂接口
interface ShapeFactory {
    Shape createShape();
}

// 2. 具体工厂类 - 圆形工厂
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

// 3. 具体工厂类 - 矩形工厂
class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

// 4. 具体工厂类 - 三角形工厂
class TriangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}

// 5. 具体产品类 - 圆形
class Circle implements Shape {
    // 具体实现
}

// 6. 具体产品类 - 矩形
class Rectangle implements Shape {
    // 具体实现
}

// 7. 具体产品类 - 三角形
class Triangle implements Shape {
    // 具体实现
}