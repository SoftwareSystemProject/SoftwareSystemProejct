import '../../Css/GroupItem.css';
import groupItem_image from '../../img/groupItem_image.jpg';
import React from 'react';

function GroupItemView() {
  return (
    <div id="groupItem_view_main">
        <div class="groupItem">
            <img class="groupItem_image" src={groupItem_image}></img>
            <div class="groupItem_info">
                <div class="groupItem_name">공동구매 물품 이름</div>
                <div class="groupItem_likeCount">찜 개수 100</div>
                <div class="groupItem_state">공동구매 진행중</div>
            </div>
        </div>
        <div class="groupItem">
            <img class="groupItem_image" src={groupItem_image}></img>
            <div class="groupItem_info">
                <div class="groupItem_name">공동구매 물품 이름</div>
                <div class="groupItem_likeCount">찜 개수 100</div>
                <div class="groupItem_state">공동구매 종료</div>
            </div>
        </div>
        <div class="groupItem">
            <img class="groupItem_image" src={groupItem_image}></img>
            <div class="groupItem_info">
                <div class="groupItem_name">공동구매 물품 이름</div>
                <div class="groupItem_likeCount">찜 개수 100</div>
                <div class="groupItem_state">공동구매 종료</div>
            </div>
        </div>
        <div class="groupItem">
            <img class="groupItem_image" src={groupItem_image}></img>
            <div class="groupItem_info">
                <div class="groupItem_name">공동구매 물품 이름</div>
                <div class="groupItem_likeCount">찜 개수 100</div>
                <div class="groupItem_state">공동구매 종료</div>
            </div>
        </div>
    </div>
  );
}

export default GroupItemView;