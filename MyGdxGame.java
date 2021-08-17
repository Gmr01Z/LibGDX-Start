package com.zhang;

import com.badlogic.gdx.Game;

/*
This class controls which game screen is being shown
 */

public class MyGdxGame extends Game{
	@Override
	public void create(){
		setScreen(new GameplayScreen());
	}
}

