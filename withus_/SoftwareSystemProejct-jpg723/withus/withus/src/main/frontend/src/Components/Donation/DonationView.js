import '../../Css/Donation.css';
import donation_image from '../../img/donation_image.png';
import React, { useState, useEffect } from "react";
import axios from 'axios'; import { Link } from 'react-router-dom';

function DonationView() {

    const [donationList , SetDonationList] = useState([]);

    useEffect(()=> {
        axios.get('/donationList').then((res)=>{
            SetDonationList(res.data)
          //console.log(res)
        })
        .catch(error => console.log(error))
      },[])

 return (
    donationList.map(function(a,i){
    return(
            <div class="donation">
                <Link to={'/donationList/detail/'+donationList[i].donation_id}> 
                <img class="donation_image" src={donation_image}></img>
                <span class="donation_info">
                    <div class="donation_name">이름 {donationList[i].donation_name}</div>
                    <div class="donation_likeCount">찜개수 {donationList[i].like_count}</div>
                    <div class="donation_state">마감 {donationList[i].donation_closeState}</div>
                </span>
                </Link>
            </div>
   )
    })
);
}

export default DonationView;