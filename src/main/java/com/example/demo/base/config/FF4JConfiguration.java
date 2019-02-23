/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2013-2016 the original author or authors.
 */

package com.example.demo.base.config;

import javax.sql.DataSource;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.property.PropertyInt;
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc;
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc;
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@Configuration
public class FF4JConfiguration {
    
	@Autowired
    private DataSource dataSource;
	
    @Bean
    public FF4j getFF4j() {
    	FF4j ff4j = new FF4j();
//                .createProperty(new PropertyInt("maxLoginAttempts", 12));
//           
//            Feature exp = new Feature("AwesomeFeature");
//            exp.enable();
//            exp.setDescription("some desc11111");
//            ff4j.createFeature(exp);
    	
    	ff4j.setFeatureStore(new FeatureStoreSpringJdbc(dataSource));
        ff4j.setPropertiesStore(new PropertyStoreSpringJdbc(dataSource));
        ff4j.setEventRepository(new EventRepositorySpringJdbc(dataSource));
        return ff4j;
    }
}

