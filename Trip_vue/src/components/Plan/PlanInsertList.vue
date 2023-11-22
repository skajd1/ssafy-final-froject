<script setup>
import PlanInsertListItem from "@/components/Plan/PlanInsertListItem.vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { ref, watch } from "vue";
</script>

<template>
  추가한 리스트 목록
  <div class="container">
    <div id="items">
      <PlanInsertListItem v-for="plan in plans" :p="plan"></PlanInsertListItem>
    </div>
  </div>
</template>

<style scoped>
#items {
}
</style>
