package databaseutils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateutility.HibernateUtility;
@SuppressWarnings("unchecked")
public class ItemDetailsMasterDaoImpl implements ItemDetailsMasterDao{

	@Override
	public boolean insertItemDetails(ItemDetailsMasterDto itemDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.save(itemDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItemDetails(ItemDetailsMasterDto itemDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.update(itemDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItemDetails(int itemId) {
		try {
			ItemDetailsMasterDto idm=this.findItemById(itemId);
			Session session=HibernateUtility.getSession();
			session.delete(idm);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ItemDetailsMasterDto> findItemByName(String itemName) {
		List<ItemDetailsMasterDto> list;
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from ItemDetailsMasterDto as idm where idm.itemdescription=:na");
			query.setParameter("na", itemName);
			list=query.list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ItemDetailsMasterDto findItemById(int itemId) {
		try {
			Session session=HibernateUtility.getSession();
			ItemDetailsMasterDto itemDetails=(ItemDetailsMasterDto)session.get(ItemDetailsMasterDto.class, itemId);
			HibernateUtility.closeSession();
			return itemDetails;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ItemDetailsMasterDto> getAllItemDetails() {
		List<ItemDetailsMasterDto> list=null;
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from ItemDetailsMasterDto");
			list=query.list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		ItemDetailsMasterDto idm=new ItemDetailsMasterDto();
//		idm.setImageurl("some url11");
//		idm.setItemdescription("Hello11");
//		idm.setItemno(1);
//		idm.setItemprice(6765);
//		idm.setItemunits(89);
//		idm.setShopid(1);
//		new ItemDetailsMasterDaoImpl().deleteItemDetails(1);
//	}
}
