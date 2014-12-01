package ru.qatools.school.twister;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import ru.qatools.school.twister.service.DatabaseProvider;

public class DatabaseProviderTest {

	@Test
    public void dbNameTest() {
        DatabaseProvider.openConnection();
        assertThat(DatabaseProvider.getDbName(), equalTo(DatabaseProvider.DB_NAME));
    }
	
	@Test
    public void dbPathTest() {
        DatabaseProvider.openConnection();
        try {
			assertThat(DatabaseProvider.getDbPath(), notNullValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
