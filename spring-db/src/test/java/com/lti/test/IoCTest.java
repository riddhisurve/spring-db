package com.lti.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartsInventory;
import com.lti.component.CarPartsInventoryImpl1;

public class IoCTest {

	@Test
	public void testcarPartInventory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cpi=(CarPartsInventory) context.getBean("carParts2");
		CarPart cp=new CarPart();
		cp.setPartNo(114);
		cp.setName("Color");
		cp.setCarModel("Suzuki");
		cp.setQuantity(10);
		cpi.addNewPart(cp);
		
	}
	
	@Test
	public void testgetAvailableParts() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cpi1=(CarPartsInventory) context.getBean("carParts1");
		List<CarPart> list = cpi1.getAvailableParts();
		
		for(CarPart c:list) {
			System.out.println("===========================");
			System.out.println("Part Details : ");
			System.out.println("No. :  " + c.getPartNo());
	        System.out.println("Name : " + c.getName());
	        System.out.println("Car Model : " + c.getCarModel());
	        System.out.println("Quantity : " + c.getQuantity()+"\n");
		}
		
	}
	
	@Test
	public void testcarPartInventoryImpl3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cpi=(CarPartsInventory) context.getBean("carParts3");
		CarPart cp=new CarPart();
		cp.setPartNo(113);
		cp.setName("Tyre");
		cp.setCarModel("Maruti 800");
		cp.setQuantity(50);
		cpi.addNewPart(cp);
		
	}

	@Test
	public void testgetAvailablePartsImpl3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cpi1=(CarPartsInventory) context.getBean("carParts3");
		List<CarPart> list = cpi1.getAvailableParts();
		
		for(CarPart c:list) {
			System.out.println("===========================");
			System.out.println("Part Details : ");
			System.out.println("No. :  " + c.getPartNo());
	        System.out.println("Name : " + c.getName());
	        System.out.println("Car Model : " + c.getCarModel());
	        System.out.println("Quantity : " + c.getQuantity()+"\n");
		}
		
	}
	
	@Test
	public void testcarPartInventoryImpl4() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cpi=(CarPartsInventory) context.getBean("carParts4");
		CarPart cp=new CarPart();
		cp.setPartNo(113);
		cp.setName("Seat Belt");
		cp.setCarModel("Maruti 800");
		cp.setQuantity(300);
		cpi.addNewPart(cp);
		
	}
	
}
