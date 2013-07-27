package com.cloudtech.sante.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cloudtech.sante.R;
import com.cloudtech.sante.model.Allergy;
import com.cloudtech.sante.model.Doc;
import com.cloudtech.sante.model.DocCategory;
import com.cloudtech.sante.model.PreviousHistory;
import com.cloudtech.sante.model.Treatment;
import com.cloudtech.sante.model.User;
import com.cloudtech.sante.model.Vaccin;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	private static String DATABASE_NAME = "masante.db";
	private static int DATABASE_VERSION = 1;
	
	private Dao<User, Integer> userDao;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
	}

	/**
	 * This is called when the database is first created. Usually you should call createTable statements here to create
	 * the tables that will store your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, User.class);
			TableUtils.createTable(connectionSource, Vaccin.class);
			TableUtils.createTable(connectionSource, Treatment.class);
			TableUtils.createTable(connectionSource, PreviousHistory.class);
			TableUtils.createTable(connectionSource, DocCategory.class);
			TableUtils.createTable(connectionSource, Doc.class);
			TableUtils.createTable(connectionSource, Allergy.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
	 * the various data to match the new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion,
			int newVersion) {
		
//		try {
//			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
//			// TODO Modify the database here
//			
//			// after we drop the old databases, we create the new ones
//			onCreate(db, connectionSource);
//		} catch (SQLException e) {
//			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
//			throw new RuntimeException(e);
//		}

	}
	
	public Dao<User, Integer> getUserDao() throws SQLException{
		if(userDao==null){
			userDao = getDao(User.class);
		}
		return userDao;
	}
}