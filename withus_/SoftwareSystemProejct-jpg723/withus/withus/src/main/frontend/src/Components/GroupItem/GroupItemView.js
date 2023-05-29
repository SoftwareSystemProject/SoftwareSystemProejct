import '../../Css/GroupItem.css';
import styles from "../../Css/Product.module.css";
import groupItem_image from '../../img/groupItem_image.jpg';
import groupItem_image1 from '../../img/groupitem_image14.PNG';
import groupItem_image2 from '../../img/groupitem_image11.jpg';
import groupItem_image3 from '../../img/groupitem_image12.jpg';
import groupItem_image4 from '../../img/groupitem_image13.png';
import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Link } from 'react-router-dom';

function GroupItemView(){

    const [list , SetList] = useState([]);
    
    const photos = [groupItem_image1, groupItem_image2,groupItem_image3, groupItem_image4]

    const convertPrice = (price) =>{
      return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
    }
    useEffect(()=> {
      axios.get('/groupItem').then((res)=>{
        SetList(res.data)
        console.log(res)
      })
      .catch(error => console.log(error))
    },[])
      

      return (
        <div id="groupItem_view_main">
        {
        list.map(function(a,i){
          return(
            <div className={styles.product}>  
               <Link to={'/groupItem/detail/'+list[i].groupItem_id} className="/groupItem">  
            <div className={styles.product_image}>       
            <img className="groupItem_image" src={photos[i]}></img>
            </div>
            </Link>
            <div className={styles.product_name}>
              <span className={styles.store}>{list[i].groupItem_name}</span>
              </div>
            <div className={styles.product_price}>
              <span className={styles.price}>{convertPrice(list[i].groupItem_price)}</span>
              <span className={styles.unit}>원</span>
              </div>

            <div className="groupItem_num">
              <span>{list[i].groupItem_num}</span>
              </div>
              </div>  
              
         
          )
          
        })
    }

      </div>   



      );
}


export default GroupItemView;