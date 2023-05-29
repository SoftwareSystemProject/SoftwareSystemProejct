import { Routes, Route} from 'react-router-dom';
import "./App.css";
import Header from './Components/Main/Header.js';
import MainCategory from './Components/Main/MainCategory.js';
import Main from './Components/Main/Main.js';
import Item from './Components/Item/ItemMain.js';
import GroupItem from './Components/GroupItem/GroupItemMain.js';
import GroupItemDetail from './Components/GroupItem/GroupItemDetail.js';
import DonationView from './Components/Donation/DonationView.js';
import Register from './Components/Member/User_register.js';
import Login from './Components/Member/User_login.js';
import Mypage from './Components/Mypage/Mypage.js';
import DonationDetail from './Components/Donation/DonationDetail.js';
import DonationMain from './Components/Donation/DonationMain.js';

function App() {
  return (
    <div className="App">
      <Header/>
      <MainCategory/>
      <Routes>
        <Route path="/" element={<Main />}/>
        <Route path="/item" element={<Item />}/>
        <Route path="/groupItem" element={<GroupItem />}/>
        <Route path="/groupItem/detail/:id" element={<GroupItemDetail />}/>
        <Route path="/donationList" element={<DonationView />}/>
        <Route path="/donationList/detail/:id" element={<DonationDetail />}/>
        <Route path="/donation" element={<DonationMain />}/>
        <Route path="/register" element={<Register />}/>
        <Route path="/login" element={<Login />}/>
        <Route path="/mypage" element={<Mypage />}/>
      </Routes>
    </div>
  );
}

export default App;