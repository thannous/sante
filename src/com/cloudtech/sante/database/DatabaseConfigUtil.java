package com.cloudtech.sante.database;

import java.io.IOException;
import java.sql.SQLException;

import com.cloudtech.sante.model.Allergy;
import com.cloudtech.sante.model.Doc;
import com.cloudtech.sante.model.DocCategory;
import com.cloudtech.sante.model.PreviousHistory;
import com.cloudtech.sante.model.Treatment;
import com.cloudtech.sante.model.User;
import com.cloudtech.sante.model.Vaccin;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
	private static final Class<?>[] classes = new Class[] {
		User.class,
		Allergy.class,
		DocCategory.class,
		Doc.class,
		PreviousHistory.class,
		Treatment.class,
		Vaccin.class
	};

	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt", classes);
	}
}
