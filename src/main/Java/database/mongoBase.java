package database;

/**
 * @author Yilin lou
 * @date 2/13/20 10:12 下午
 * @Email:ylou7@stevens.edu
 */

import com.mongodb.*;

import java.net.UnknownHostException;

public class mongoBase {

    //link mongodb
    MongoClient mongoClient = new MongoClient("localhost",27017);

    //link database
    DB db = mongoClient.getDB("IDTIP");

    //choose collection
    DBCollection collection = db.getCollection("IPLocation");
    //显示集合中的数据,查询集合时，常返回DBCursor对象
//        DBCursor cursor = collection.find();
//        System.out.println("一共有"+cursor.count()+"条文档");
//
    public void insert(String country,String ip,String city,String region,String latitude,String longitude){

        BasicDBObject obj = new BasicDBObject();
        obj.put("ip",ip);
        obj.put("city",city);
        obj.put("region",region);
        obj.put("country",country);
        obj.put("latitude",latitude);
        obj.put("longitude",longitude);
        collection.insert(obj);
//        DBCursor cursor = collection.find();

//        System.out.println("一共有"+cursor.count()+"条文档");
        System.out.println("insert successful");
    }
    public void show_all(){
        BasicDBObject basicDBObject = new BasicDBObject();
        Cursor cursor = collection.find(basicDBObject);

        while(cursor.hasNext()){
            DBObject obj = cursor.next();
            System.out.println(obj.toString());
            System.out.println(obj.get("city"));
        }
    }

    public Cursor returnall(){
        BasicDBObject basicDBObject = new BasicDBObject();
        Cursor cursor = collection.find(basicDBObject);
        return cursor;

    }

    public boolean isthere(String ip){
        BasicDBObject queryObject = new BasicDBObject("ip",ip);
        Cursor cursor = collection.find(queryObject);


        if(!cursor.hasNext()){
            System.out.println("it's a new ip");
            return false;
        }
        else {
            System.out.println("it has been");
            return true;
        }
    }

    public void delete1(String ip){
        BasicDBObject query = new BasicDBObject("ip", ip);
        collection.remove(query);

    }
    public void lastest(int n){
        DBCursor cursor = collection.find();
        int totalnumber=cursor.count();
        int start=totalnumber-n;

        DBCursor cursor1 = collection.find().limit(n).skip(start);
        while (cursor1.hasNext()){
            DBObject obj = cursor1.next();
            System.out.println(obj.toString());

        }




    }

    public static void main(String[] args) throws UnknownHostException {
        mongoBase mongoBase=new mongoBase();
//        Cursor re = mongoBase.returnall();
//        System.out.println(re);
//        while(re.hasNext()) {
//            DBObject obj = re.next();
//            System.out.println(obj.toString());
//        }

//        mongoBase.show_all();
//        String checkip="39.179.55.194";
//        mongoBase.isthere(checkip);
        mongoBase.lastest(100);
    }

}
