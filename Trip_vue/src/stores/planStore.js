import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { getGugun, getTripInfo, getSido, getMyPlans } from "@/api/TripApi.js";
// 라우터 변경 테스트 해보기
const usePlanStore = defineStore("usePlanStore", () => {
  //1. state
  const plans = ref([]);
  const plan = ref({});
  //2. action
  const allPlan = (uid) => {
    getMyPlans(
      uid,
      (res) => {
        plans.value = res.data;
      },
      (err) => {
        console.log(err);
      }
    );
  };

  //3. getter
  const all = computed(() => plans.value);
  return {
    allPlan,
    all,
  };
});

export { usePlanStore };
