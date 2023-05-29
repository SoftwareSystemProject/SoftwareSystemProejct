import {useParams} from "react-router-dom";
import React, { useState, useEffect } from 'react';
import axios from 'axios';

 function DonationDetail() {

    let { id } = useParams();

    const [donation, setDonation] = useState("");

    useEffect(()=>{
        axios.get("/donationList/detail/"+id).then((res)=>{
            if(res.data){
                setDonation(res.data);
            }else{
                alert("failed to");
            }
        });
    }, []);

    return(
        <div className="donationDetail">
        <span className="donationDetail">{donation.donation_id}</span>
        <span className="donationDetail">{donation.donation_name}</span>
        </div>
    );
}
export default DonationDetail;
