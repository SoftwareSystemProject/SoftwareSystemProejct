import '../../Css/Mypage.css';
import React from 'react';
import {Link} from 'react-router-dom';


function Mypage() {
  return (
    <div>
        <div id="mypage_category">
            <div id="mypage_cate">마이페이지</div>
            <Link to="/likepage" class="mypageCate_content"><div class="mypageCate_content">찜한 상품</div></Link>
            <Link to="/mywritepage" class="mypageCate_content"><div class="mypageCate_content">내가 쓴 나눔글</div></Link>
            <Link to="/mydonationpage" class="mypageCate_content"><div class="mypageCate_content">기부 내역</div></Link>
            <Link to="/myitempage" class="mypageCate_content"><div class="mypageCate_content">나눔 내역</div></Link>
            <Link to="/my-groupitem-page" class="mypageCate_content"><div class="mypageCate_content">공동구매 참여 내역</div></Link>
            <Link to="/my-info-page" class="mypageCate_content"><div class="mypageCate_content">개인정보수정</div></Link>
        </div>
    </div>
  );
}

export default Mypage;