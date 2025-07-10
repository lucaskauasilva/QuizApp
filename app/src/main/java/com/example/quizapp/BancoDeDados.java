package com.example.quizapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Questoes.class}, version = 1)
public abstract class BancoDeDados extends RoomDatabase{

}
