<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import Search from "@/components/common/Search.vue";
import Login from "@/views/User/Login.vue";
import Regist from "@/views/User/Regist.vue";
import { useTripStore } from "@/stores/tripStore";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";

const router = useRouter();
const userStore = useUserStore();
const store = useTripStore();
const userstore = useUserStore();

const { isLogin } = storeToRefs(userStore); // 로그인 여부
const { keyword: keyword } = storeToRefs(store);

const search = () => {
  if (keyword.value === "") {
    alert("검색어를 입력해주세요");
    return;
  }
  router.push("/search" + "?keyword=" + keyword.value);
};

const loginFrom = ref(false);
const registFrom = ref(false);

const changeLoginFrom = () => {
  loginFrom.value = true;
  registFrom.value = false;
};
const changeJoinFrom = () => {
  registFrom.value = true;
  loginFrom.value = false;
};

const goMain = () => {
  router.push("/main");
};

const logout = () => {
  userstore.logout();
  alert("로그아웃 되었습니다.");
  router.push({ name: "Home" });
};
</script>

<template>
  <div id="container">
    <h1>
      <span id="goMain" @click="goMain()">
        <div style="font-size: 14px; margin-left: 600px; font-weight: bold">냐멍이</div>
        어디로 가냥?

        <img src="@/assets/logo1.svg" />
      </span>
    </h1>
    <div v-if="isLogin == true" id="SearchPage">
      <div id="SearchBar">
        <Search></Search>
        <button @click="search">검색</button>
      </div>
      <div>
        <input type="button" value="로그아웃" @click="logout()" />
      </div>
    </div>
    <div v-else>
      <div id="userbar">
        <input
          type="button"
          value="로그인"
          @click="changeLoginFrom()"
          :class="loginFrom ? 'onform' : 'offform'"
        />
        <input
          type="button"
          value="회원가입"
          @click="changeJoinFrom()"
          :class="registFrom ? 'onform' : 'offform'"
        />
      </div>
      <div class="userSector" v-if="loginFrom === true">
        <Login />
      </div>
      <div class="userSector" v-if="registFrom == true">
        <Regist />
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
h1 {
  font-size: 100px;
  text-align: center;
  color: var(--main-color);
}
#container {
  padding-top: 10rem;
  background-color: var(--vt-c-bg);
  height: 100vh;
}
#SearchBar {
  width: 60%;
  display: flex;

  align-items: center;
  margin: 0 auto;
}
button {
  margin-top: 2rem;
  width: 100px;
  height: 50px;
  font-size: 30px;
  border: none;
  border-radius: 10px;
  background-color: var(--main-color);
  color: var(--main-color-bg);

  text-align: center;
  margin-left: 1rem;
}

#userbar {
  display: flex;
  justify-content: center;
  margin: 0 auto;
}

.onform {
  background-color: transparent;
  border-top: none;
  border-left: none;
  border-right: none;
  border-bottom: 2px solid var(--main-color);

  text-align: center;
  font-size: 30px;
  font-weight: bold;
  color: var(--main-color);
  padding: 5px 20px;
  margin: 100px 0px 0 30px;
}

.offform {
  background-color: transparent;
  border-radius: 30px;
  border: none;

  text-align: center;
  font-size: 30px;
  color: var(--main-color);
  padding: 5px 20px;
  margin: 100px 0px 0 30px;

  &:hover {
    font-weight: bold;
  }
}

#SearchPage {
  display: flex;
  flex-direction: column;

  align-items: center;

  input {
    background-color: transparent;
    border-radius: 30px;
    border: none;

    text-align: center;
    font-size: 30px;
    color: var(--main-color);
    padding: 5px 20px;
    margin-top: 100px;
    margin-right: 100px;

    font-size: 20px;
  }
}

span {
  cursor: pointer;
}
</style>
