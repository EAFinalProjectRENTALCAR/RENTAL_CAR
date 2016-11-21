INSERT INTO `category` VALUES (NULL,'Car')
INSERT INTO `category` VALUES (NULL,'SUV')
INSERT INTO `category` VALUES (NULL,'Truck')
INSERT INTO `category` VALUES (NULL,'Van')
--
--
INSERT INTO `vehicleClass` VALUES (NULL,'Economy')
INSERT INTO `vehicleClass` VALUES (NULL,'Intermediate')
INSERT INTO `vehicleClass` VALUES (NULL,'Standard')
INSERT INTO `vehicleClass` VALUES (NULL,'Premium')
--
--
INSERT INTO `vehicle`(id,bags,capacity,description,price,specialFeatures,vehicleId,category_id,vehicleClass_id) VALUES (NULL,2,4,'Toyota Cambri',70,'Automatic, Air Conditioning, AM/FM Stereo and CD',101,1,1)
INSERT INTO `vehicle`(id,bags,capacity,description,price,specialFeatures,vehicleId,category_id,vehicleClass_id) VALUES (NULL,3,6,'TATA Sumo',120,'Cruise Control, Automatic, Air Conditioning',102,3,2)
INSERT INTO `vehicle`(id,bags,capacity,description,price,specialFeatures,vehicleId,category_id,vehicleClass_id) VALUES (NULL,2,4,'Mazda CS-5',100,'Cruise Control, Air Conditioning, AM/FM Stereo',103,2,4)