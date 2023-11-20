import { ref } from "vue";
import { defineStore } from "pinia";
import {} from "@/api/UserApi.js";
// 라우터 변경 테스트 해보기
const useUserStore = defineStore("useUserStore", () => {
  const isLogin = ref(false);

  const userLogin = (loginUser) => {
    userConfirm(
      loginUser,
      (response) => {
        if (response.data == true) {
          // if (response.status === 200) {
          isLogin = true;
          console.log("로그인 성공했다");
        } else {
          console.log("로그인 실패했다");
        }
      },
      (error) => {
        console.error(error);
      }
    );
  };

  return {
    isLogin,
    userLogin,
  };
});

export { useUserStore };
