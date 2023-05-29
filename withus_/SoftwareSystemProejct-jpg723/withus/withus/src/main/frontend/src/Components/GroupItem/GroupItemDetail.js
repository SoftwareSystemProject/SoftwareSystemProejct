import {useParams } from "react-router-dom";
import styles from '../../Css/GroupItemDetail.module.css';
import '../../Css/GroupItem.css';
import Modal from '../Modal/Modals.js';
import AttendGroupItem from './AttendGroupItem.js';
import groupItem_image14 from '../../img/groupitem_image14.PNG';
import groupItem_image11 from '../../img/groupitem_image11.jpg';
import groupItem_image12 from '../../img/groupitem_image12.jpg';
import groupItem_image13 from '../../img/groupitem_image13.png';
import React, { useState, useEffect } from 'react';
import axios from 'axios';

 function GroupItemDetail(props) {

    let { id } = useParams();
    const photos = [groupItem_image11, groupItem_image12, groupItem_image13, groupItem_image14]

    const [groupItem, setGroupItem] = useState("");

    useEffect(()=>{
        axios.get("/groupItem/detail/"+id).then((response)=>{
            if(response.data){
                console.log(response.data);
                setGroupItem(response.data);
            }else{
                alert("failed to");
            }
        });
    }, []);

    //가격 형식
    const convertPrice = (price) =>{
      return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",");
    }

    //수량
    const [count, setCount] = useState(1);
    const handleQuantity = (type) => {
      if(type === "plus"){
        setCount(count+1)
      }else{
        if(count === 1) return;
        setCount(count - 1);
      }
    }

    //공동구매참여 모달창
    // useState를 사용하여 open상태를 변경한다. (open일때 true로 만들어 열리는 방식)
  const [modalOpen, setModalOpen] = useState(false);

  const openModal = () => {
    setModalOpen(true);
  };
  const closeModal = () => {
    setModalOpen(false);
  };

    return(
      <div>
        <main className={styles.main}>
          <section className={styles.product}>
            <div className={styles.product_img}>
            <img className="groupItem_image" src={photos[id-11]}></img>
            </div>
          </section>
          <section className={styles.product}>
            <div className={styles.product_info}>
              <p className={styles.product_name}>{groupItem.groupItem_name}</p>
              <span className={styles.price}>
              {convertPrice(groupItem.groupItem_price*groupItem.groupItem_rate/100+"")}
                <span className={styles.unit}>원</span>
              </span>
            </div>
            <p className={styles.seller_store}>{groupItem.groupItem_detail}</p>
           
            <div className={styles.delivery}>
              <p>택배배송 / 무료배송</p>
            </div>
  
            <div className={styles.line}></div>
  
            <div className={styles.amount}>
              <img
                className={styles.minus}
                src="/icon-minus-line.svg"
                alt="minus"
                onClick={() => handleQuantity("minus")}
              />
  
              <div className={styles.count}>
                <span>{count}</span>
              </div>
  
              <img
                className={styles.plus}
                src="/icon-plus-line.svg"
                alt="plus"
                onClick={() => handleQuantity("plus")}
              />
            </div>
  
            <div className={styles.line}></div>
  
            <div className={styles.sum}>
              <div>
                <span className={styles.sum_price}>총 상품 금액</span>
              </div>
  
              <div className={styles.total_info}>
                <span className={styles.total}>
                  총 수량 <span className={styles.total_count}>{count}개</span>
                </span>
                <span className={styles.total_price}>
                  {convertPrice(groupItem.groupItem_price*count)}
                  <span className={styles.total_unit}>원</span>
                </span>
              </div>
            </div>
  
            <div className={styles.btn}>
              <button className={styles.btn_buy}  onClick={openModal}>
        주문하기
        </button>
        <Modal open={modalOpen} close={closeModal} header="결제">
          <main> {props.children} </main>
          주문자 정보 폼
          <button className={styles.btn_buy}>결제</button>
      </Modal>
              <button className={styles.btn_cart}>장바구니</button>
            </div>

            
          </section>
        </main>
        <AttendGroupItem/>
        
</div>



    );
}
export default GroupItemDetail;
