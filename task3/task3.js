//task1
db.people.findOne()

//task2
db.people.findOne({sex: "Female", nationality: "China"})

//task3
db.people.find({sex: "Male", nationality: "Germany"})

//task4
db.people.find({"weight":{"$gte":"68","$lt":"71.5"}})

//task5
db.people.find({"birth_date":{"$gte":"2000-12-31"}}, {"first_name":1, "last_name":1, "location.city": 1})

//task6
db.people.insert({
        "sex" : "Male", 
        "first_name" : "Ihor", 
        "last_name" : "Debelyi", 
        "job" : "Middle Developer", 
        "email" : "ihord@pjwstk.edu.pl", 
        "location" : {
            "city" : "Warsaw", 
            "address" : {
                "streetname" : "Koszykowa", 
                "streetnumber" : "86"
            }
        }, 
        "description" : "random description", 
        "height" : "182", 
        "weight" : "85", 
        "birth_date" : "1999-04-12T10:22:07Z", 
        "nationality" : "Ukraine", 
        "credit" : [
            {
                "type" : "jcb", 
                "number" : "3529195112892553", 
                "currency" : "PLN", 
                "balance" : "1000004265.17"
            }
        ]
    })

    //task7
    db.people.remove({"height": {"$gt": "190"}})

    //task8
    db.people.update({"location.city":"Moscow"}, {"$set":{"location.city": "Moskwa"}}, {multi:true})

    //task9
    db.people.update({"first_name":"Antonio"}, {"$set":{"hobby": "table tenis"}}, {multi:true})

    //task10
    db.people.update({"job":"Editor"}, {"$unset":{"email": 1}}, {multi:true})

