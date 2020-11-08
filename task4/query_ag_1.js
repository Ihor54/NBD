const aggregationTask1 = [
    { 
        $group: {	_id: "$sex", 
                  averageHeight: { $avg: {"$toDouble": "$height"} },
                  averageWeight: { $avg: {"$toDouble": "$weight"}}
              }
    },
    {
        $sort: {
            _id: 1
        }
    }
  ];

  
  
printjson(db.people.aggregate(aggregationTask1).toArray());