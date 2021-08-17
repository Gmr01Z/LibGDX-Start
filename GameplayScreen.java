package com.zhang;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameplayScreen implements Screen {
    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;
    //draw graphics
    private SpriteBatch spriteBatch;
    //draw shapes
    private ShapeRenderer shapeRenderer;
    //view virtual world
    private Camera camera;
    //control camera: zoom in/out; keep everything scaled
    private Viewport viewport;

    //runs one time at beginning
    //all setup should happen here
    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.position.set(WORLD_WIDTH/2, WORLD_HEIGHT/2, 0);
        camera.update();

        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        spriteBatch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
    }

    public void clearScreen(){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    //this method runs as fast as it can, repeatedly, constantly looped
    @Override
    public void render(float delta) {
        clearScreen();
        shapeRenderer.begin();
        shapeRenderer.setColor(1,1,0,1);
        shapeRenderer.circle(30,30,30);
        shapeRenderer.end();

        spriteBatch.begin();
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        shapeRenderer.dispose();
    }
}
