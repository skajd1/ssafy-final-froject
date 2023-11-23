<script setup>
import MyListItem from "@/components/MyList/MyListItem.vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { ref, reactive } from "vue";
import { useUserStore } from "@/stores/userStore";
const store = usePlanStore();
const { allPlan } = store;
const { all: items } = storeToRefs(store);
const { user } = storeToRefs(useUserStore());

allPlan(user.value.uid);
</script>

<template>
  <div>내 계획들 확인하는 뷰에용</div>
  <div class="container">
    <MyListItem v-for="item in items" :item="item" />
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
