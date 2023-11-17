import { ref, computed } from "vue";
import { defineStore } from "pinia";
import {} from "@/api/UserApi.js";
// 라우터 변경 테스트 해보기
const useUserStore = defineStore("useUserStore", () => {
  //1. state
  const customers = ref([]);
  const customer = ref({});
  //2. action
  const allCustomer = () => {
    selectAll(
      (res) => {
        customers.value = res.data;
      },
      (e) => {
        console.log(e);
      }
    );
  };

  //3. getter
  const all = computed(() => customers.value);
  const one = computed(() => customer.value);
  return {
    allCustomer,
  };
});

export { useUserStore };
