import { ref, computed } from "vue";
import { defineStore } from "pinia";
// import { getTripInfoById } from "@/api/TripApi.js";
const useTripStore = defineStore("useTripStore", () => {
  const tripItems = ref([]);
  const initItems = () => {
    tripItems.value = [];
  };
  const key = ref("");

  const keyword = computed({
    get: () => key.value,
    set: (value) => (key.value = value),
  });

  return {
    initItems,
    tripItems,
    keyword,
  };
});
export { useTripStore };
