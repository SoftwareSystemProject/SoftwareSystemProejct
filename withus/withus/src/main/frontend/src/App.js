import { Routes, Route} from 'react-router-dom';
import React from 'react';
import Header from './Components/Main/Header.js';
import MainCategory from './Components/Main/MainCategory.js';
import Main from './Components/Main/Main.js';
import Item from './Components/Item/ItemMain.js';
import GroupItem from './Components/GroupItem/GroupItemMain.js';
import Donation from './Components/Donation/DonationMain.js';
import Register from './Components/Member/User_register.js';
import Login from './Components/Member/User_login.js';
import Mypage from './Components/Mypage/Mypage.js';

function App() {
  return (
    <div className="App">
      <Header/>
      <MainCategory/>
      <Routes>
        <Route path="/" element={<Main />}/>
        <Route path="/item" element={<Item />}/>
        <Route path="/groupItem" element={<GroupItem />}/>
        <Route path="/donation" element={<Donation />}/>
        <Route path="/register" element={<Register />}/>
        <Route path="/login" element={<Login />}/>
        <Route path="/mypage" element={<Mypage />}/>
      </Routes>
    </div>
  );
}

export default App;