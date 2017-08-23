package com.starlightsoftware.sample.notekeeper;

import android.app.Application;

import com.starlightsoftware.sample.notekeeper.greendao.DaoMaster;
import com.starlightsoftware.sample.notekeeper.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class App extends Application {

		private DaoSession daoSession;

		@Override
		public void onCreate() {
				super.onCreate();

				DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
				Database db = helper.getWritableDb();
				daoSession = new DaoMaster(db).newSession();
		}

		public DaoSession getDaoSession() {
				return daoSession;
		}
}
