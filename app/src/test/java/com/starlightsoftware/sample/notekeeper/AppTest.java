package com.starlightsoftware.sample.notekeeper;

import android.app.Application;

import com.starlightsoftware.sample.notekeeper.greendao.DaoSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class AppTest {

		@Test
		public void canCreate() {
				App app = new App();
				assertNotNull(app);
				assertEquals(Application.class, app.getClass().getSuperclass());
		}

		@Test
		public void getGreenDaoSession() {
				App app = new App();
				DaoSession daoSession = app.getDaoSession();
		}
}