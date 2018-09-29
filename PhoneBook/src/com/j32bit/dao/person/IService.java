package com.j32bit.dao.person;

import java.util.Properties;

public interface IService {
	
    void start(Properties prop) throws ClassNotFoundException;

    void finish();
 
}
