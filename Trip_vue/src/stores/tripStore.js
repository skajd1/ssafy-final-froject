import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { getTripInfoById } from "@/api/TripApi.js";
const useTripStore = defineStore("useTripStore", () => {
  const tripitem = ref({});
  function getTripItem(id) {
    getTripInfoById(
      id,
      (response) => {
        tripitem.value = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  const item = computed(() => tripitem.value);
  return {
    getTripItem,
    item,
  };
});
export { useTripStore };
