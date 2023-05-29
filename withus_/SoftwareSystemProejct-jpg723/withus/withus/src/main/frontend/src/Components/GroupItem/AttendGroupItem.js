import React, { useState, useEffect } from "react";
import '../../Css/AttendGroupItem.css';
import axios from 'axios';

function AttendGroupItem() {

    const [attendgroupList , SetGroupList] = useState([]);


    useEffect(()=> {
        axios.get('/attendgroupList').then((res)=>{
          SetGroupList(res.data)
          console.log(res)
        })
        .catch(error => console.log(error))
      },[])

      
      return (
        <div>
        {
        attendgroupList.map(function(a,i){
          return(
            <div className="todoapp__item">
            <span className="todoapp__item-ctx">{attendgroupList[i].user_name}</span>
            <span className="todoapp__item-ctx">{attendgroupList[i].totalGroupItem_count}</span>
            </div>
          )
          
        })
    }
        </div>
        );
   
}


export default AttendGroupItem;