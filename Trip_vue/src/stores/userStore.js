import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { loginConfirm, getInfo, regist, changePw, deleteAccount } from "@/api/UserApi.js";
// 라우터 변경 테스트 해보기
const isLoading = ref(false);

const useUserStore = defineStore(
  "useUserStore",
  () => {
    const userInfo = ref({
      uid: "",
      id: "",
      nickname: "",
      admin: false,
    });

    const isLogin = ref(false);

    const login = async (id, pw) => {
      await loginConfirm(
        id,
        pw,
        (res) => {
          if (res.data) {
            isLogin.value = true;
          }
        },
        (err) => {
          console.log(err);
        }
      );
      console.log("login", isLogin.value);
    };

    const getUserInfo = (uid) => {
      getInfo(
        uid,
        (res) => {
          if (res.data) {
            userInfo.value.uid = res.data.uid;
            userInfo.value.id = res.data.id;
            userInfo.value.nickname = res.data.nickname;
            userInfo.value.admin = res.data.admin;
          }
        },
        (err) => {
          console.log(err);
        }
      );
    };

    const logout = () => {
      console.log("logout");
      isLogin.value = false;

      userInfo.value = {
        uid: "",
        id: "",
        nickname: "",
        admin: false,
      };
    };
    const loadingStart = () => {
      isLoading.value = true;
    };
    const loadingEnd = () => {
      isLoading.value = false;
    };
    const load = computed(() => isLoading.value);
    const user = computed(() => userInfo.value);
    return {
      login,
      logout,
      getUserInfo,
      userInfo,
      isLogin,
      user,
      load,
      loadingStart,
      loadingEnd,
    };
  },
  { persist: true }
);

export { useUserStore };
