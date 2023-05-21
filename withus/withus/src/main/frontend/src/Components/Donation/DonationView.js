import '../../Css/Donation.css';
import donation_image from '../../img/donation_image.png';
import React from 'react';

function DonationView() {
  return (
    <div id="donation_view_main">
        <div class="donation">
            <img class="donation_image" src={donation_image}></img>
            <div class="donation_info">
                <div class="donation_name">기부 이름</div>
                <div class="donation_likeCount">찜 개수 100</div>
                <div class="donation_state">마감</div>
            </div>
        </div>
        <div class="donation">
            <img class="donation_image" src={donation_image}></img>
            <div class="donation_info">
                <div class="donation_name">기부 이름</div>
                <div class="donation_likeCount">찜 개수 100</div>
                <div class="donation_state">진행중</div>
            </div>
        </div>
        <div class="donation">
            <img class="donation_image" src={donation_image}></img>
            <div class="donation_info">
                <div class="donation_name">기부 이름</div>
                <div class="donation_likeCount">찜 개수 100</div>
                <div class="donation_state">진행중</div>
            </div>
        </div>
        <div class="donation">
            <img class="donation_image" src={donation_image}></img>
            <div class="donation_info">
                <div class="donation_name">기부 이름</div>
                <div class="donation_likeCount">찜 개수 100</div>
                <div class="donation_state">진행중</div>
            </div>
        </div>
    </div>
  );
}

export default DonationView;